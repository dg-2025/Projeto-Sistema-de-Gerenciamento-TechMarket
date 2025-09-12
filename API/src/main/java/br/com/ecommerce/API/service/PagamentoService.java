package br.com.ecommerce.API.service;

import br.com.ecommerce.API.model.Pagamento;
import br.com.ecommerce.API.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository Repo) {

        this.pagamentoRepository = Repo;
    }
    //Listar pagamentos
    public List<Pagamento> listarPagamentos(){
        return this.pagamentoRepository.findAll();
    }
    //Adicionar pagamento
    public Pagamento NovoPagamento(Pagamento fazupix){
        return pagamentoRepository.save(fazupix);
    }

    //Buscar pagamento
    public Pagamento buscarPagamentoPorId(int id){
        return pagamentoRepository.findById(id).orElse(null);
    }
    //Atualizar pagamento
    public Pagamento editarPagamento(int id, Pagamento atualizado){
        Pagamento idPagamento = buscarPagamentoPorId(id);
        if(idPagamento != null){
            return null;
        }
        idPagamento.setStatus(atualizado.getStatus());
        return pagamentoRepository.save(atualizado);
    }
    //Excluir pagamento
    public Pagamento excluirPagamento(int id){
        Pagamento idPagamento = buscarPagamentoPorId(id);
        if(idPagamento != null){
            return null;
        }
        pagamentoRepository.deleteById(id);
        return idPagamento;
    }
}
