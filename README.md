# junit-mockito
springboot 整合单元测试，正确的玩法

单元测试规范
1. 对每个类的单元测试建立独立的包
  
2. 对每个方法测试建独立的类
    - 因为每个方法都有不同的case要进行测试， 所以建立独立的测试类，更加明了的管理资源
3. 所有单元测试类继承BaseTest
