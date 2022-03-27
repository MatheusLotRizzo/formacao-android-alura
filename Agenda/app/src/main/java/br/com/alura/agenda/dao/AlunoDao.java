package br.com.alura.agenda.dao;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.model.Aluno;

public class AlunoDao {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static int contadorIds = 1;

    public void salva(Aluno aluno) {
        aluno.setId(contadorIds);
        alunos.add(aluno);
        atualizaId();
    }

    private void atualizaId() {
        contadorIds++;
    }

    public void edita(Aluno aluno) {
        Aluno alunoEncontrado = buscaAlunoPorId(aluno);
        if (alunoEncontrado != null) {
            int posicaoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoAluno, aluno);
        }
    }

    @Nullable
    private Aluno buscaAlunoPorId(Aluno aluno) {
        for (Aluno a : alunos) {
            if (a.getId() == aluno.getId()) {
                return a;
            }
        }
        return null;
    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
