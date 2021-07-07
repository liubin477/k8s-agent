
## 使用
1. 修改`K8sInit`中的 k8s 配置文件路径
2. SpringBoot 项目中引入 k8s-api（注意配置`@EnableFeignClients`路径）
3. 自行修改业务逻辑

## 注意事项
1. 版本选择：https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E
2. 未做熔断降级，如有需要自行添加
3. K8s 实体类使用 Gson 序列化，在 SpringBoot 项目中使用可能会有问题（https://blog.csdn.net/boling_cavalry/article/details/107503695 ），建议将所需字段封装后再返回
