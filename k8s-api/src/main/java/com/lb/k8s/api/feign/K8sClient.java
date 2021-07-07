package com.lb.k8s.api.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.lb.k8s.api.model.R;

/**
 * @Class: K8sClient
 * @Desc: K8s 对外访问
 * @Author: liubin
 * @Date: 2021/7/7
 */
@FeignClient(value = "k8s-agent", path = "/" )
public interface K8sClient {

    @GetMapping("/listNamespace")
    R<String> listNamespace();

//    @GetMapping("/listNamespace2")
//    R<V1NamespaceList> listNamespace2();
}