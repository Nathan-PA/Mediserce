package mediarte.api.medico;

import jakarta.validation.constraints.NotNull;
import mediarte.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(

        @NotNull
        Long id,

        String nome,

        String telefone,

        DadosEndereco endereco) {
}
