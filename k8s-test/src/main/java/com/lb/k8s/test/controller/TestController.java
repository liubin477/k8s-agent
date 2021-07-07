package com.lb.k8s.test.controller;

import com.lb.k8s.api.feign.K8sClient;
import com.lb.k8s.api.model.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class: TestController
 * @Desc: 测试访问
 * @Author: liubin
 * @Date: 2021/7/7
 */
@RestController
public class TestController {

    @Autowired
    private K8sClient k8sClient;

    @GetMapping("/test")
    public R<String> test() {
        return k8sClient.listNamespace();
    }

//    @GetMapping("/test2")
//    public R<V1NamespaceList> test2() {
//        return k8sClient.listNamespace2();
//    }
}
