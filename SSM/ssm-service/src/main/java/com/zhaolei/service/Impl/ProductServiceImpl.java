package com.zhaolei.service.Impl;

import com.zhaolei.dao.ProductDao;
import com.zhaolei.domain.Product;
import com.zhaolei.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * SSM
 * 2019-05-07 18:49
 *
 * @author leonzhao
 **/

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        /*生成UUID添加到id*/
        String id = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        product.setId(id);
        productDao.save(product);
    }

    @Override
    public void deleteByIds(String[] ids) throws Exception {
        for (String id : ids) {
            productDao.deleteByid(id);
        }
    }
}
