package com.lb.k8s.config;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;

/**
 * @Class: K8sInit
 * @Desc: K8s 初始化
 * @Author: liubin
 * @Date: 2021/7/7
 */
@Component
public class K8sInit implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        File file = new File("/root/.kube/config");
        ApiClient client = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(file))).build();
        client.setDebugging(true);
        Configuration.setDefaultApiClient(client);
    }
}
