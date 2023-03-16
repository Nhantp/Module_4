package codegym.vn.repository;

import codegym.vn.model.KhaiBao;

import java.util.List;

public interface IKhaiBaoRepository {
    void create(KhaiBao khaiBao);
    List<KhaiBao>findAll();
}
