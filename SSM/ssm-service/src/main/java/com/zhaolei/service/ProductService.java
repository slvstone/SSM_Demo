package com.zhaolei.service;

import com.zhaolei.domain.Product;

import java.util.List;

/**
 * SSM
 * 2019-05-07 18:41
 *
 * @author leonzhao
 **/

public interface ProductService {
    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;

    void deleteByIds(String[] ids) throws Exception;
}
