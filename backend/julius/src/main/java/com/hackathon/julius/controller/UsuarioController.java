package com.hackathon.julius.controller;


import com.hackathon.julius.dto.RespostaPreDefinidaDTO;
import com.hackathon.julius.dto.UsuarioDTO;
import com.hackathon.julius.entity.ItemMesExtrato;
import com.hackathon.julius.entity.MesExtrato;
import com.hackathon.julius.entity.Usuario;
import com.hackathon.julius.entity.enums.TipoItemEnum;
import com.hackathon.julius.entity.enums.TipoPerfil;
import com.hackathon.julius.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> insert(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioDTO.getNome());
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setRenda(usuarioDTO.getRenda());
        usuario.setNumeroCartao(usuarioDTO.getNumeroCartao());

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        usuarioSalvo.setExtratos(criarExtratos(usuarioSalvo));
        usuarioSalvo.setTipoPerfil(criarTipoPerfil(usuarioDTO));

        usuarioRepository.save(usuarioSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    /**
     * Método para criar tipo de perfil com base na pontuação das respostas.
     * @param usuarioDTO
     * @return
     */
    private TipoPerfil criarTipoPerfil(UsuarioDTO usuarioDTO) {
        List<RespostaPreDefinidaDTO> respostas = usuarioDTO.getRespostas();
        HashMap<TipoPerfil, BigDecimal> calculos = new HashMap<>();

        Stream.of(TipoPerfil.values()).forEach(tipo -> {
            calculos.put(tipo, BigDecimal.ZERO);
        });

        respostas.forEach(resp -> {
            resp.getPontos().forEach(ponto -> {
                BigDecimal newValue = calculos.get(ponto.getTipoPerfil());
                newValue = newValue.add(new BigDecimal(ponto.getTotal()));
                calculos.put(ponto.getTipoPerfil(), newValue);
            });
        });

        return calculos
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .findFirst()
                .get().getKey();
    }

    /**
     * Método para gerar extratos mensais aleatórios.
     * @param usuario
     * @return
     */
    private List<MesExtrato> criarExtratos(Usuario usuario) {
        List<MesExtrato> extratos = new ArrayList<>();

        MesExtrato mesExtrato = new MesExtrato();

        LocalDate now = LocalDate.now();
        LocalDate before = now.minusMonths(13);

        while (before != now) {
            mesExtrato.setMesAno(before);
            mesExtrato.setUsuario(usuario);
            mesExtrato.setItems(new ArrayList<>());

            Stream.of(TipoItemEnum.values()).forEach(p -> {
                ItemMesExtrato item = new ItemMesExtrato();
                item.setTipo(p);
                item.setValor(generateRandomValue(new BigDecimal("2000")));
                mesExtrato.getItems().add(item);
            });

            BigDecimal result = mesExtrato.getItems().stream()
                    .map(ItemMesExtrato::getValor)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            mesExtrato.setGastoTotal(result);

            BigDecimal saldo = usuario.getRenda();
            saldo = saldo.subtract(result);

            mesExtrato.setSaldo(saldo);

            extratos.add(mesExtrato);
        }

        return extratos;
    }

    private BigDecimal generateRandomValue(BigDecimal max) {
        BigDecimal randFromDouble = new BigDecimal(Math.random());
        BigDecimal actualRandomDec = randFromDouble.divide(max,BigDecimal.ROUND_DOWN);

        BigInteger actualRandom = actualRandomDec.toBigInteger();
        return actualRandomDec;
    }

    @PostMapping(path = "/actions/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> login(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuario = Optional.ofNullable(usuarioRepository.findByUsuarioAndPassword(usuarioDTO.getUsuario(), usuarioDTO.getSenha()));

        return usuario.isPresent() ? ResponseEntity.ok(usuario.get()) : ResponseEntity.notFound().build();
    }


}
