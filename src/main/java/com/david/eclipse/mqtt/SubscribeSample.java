package com.david.eclipse.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author David Zheng
 * @date 2021/12/25
 */
public class SubscribeSample {


    public static void main(String[] args) throws MqttException {
        String HOST = "tcp://127.0.0.1:1883";
        String TOPIC = "mqtt/test";
        int qos = 1;
        String userName = "test";
        String passWord = "test";
        for (int i = 0;i<2000;i++){
            try {
                String clientid = "subClient"+i;
                // host为主机名，test为clientid即连接MQTT的客户端ID，一般以客户端唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
                MqttClient client = new MqttClient(HOST, clientid, new MemoryPersistence());
                // MQTT的连接设置
                MqttConnectOptions options = new MqttConnectOptions();
                // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
                options.setCleanSession(true);
                // 设置连接的用户名
                options.setUserName(userName);
                // 设置连接的密码
                options.setPassword(passWord.toCharArray());
                // 设置超时时间 单位为秒
                options.setConnectionTimeout(10);
                // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
                options.setKeepAliveInterval(20);
                // 设置回调函数
                client.setCallback(new MqttCallback() {

                    @Override
                    public void connectionLost(Throwable cause) {
                        System.out.println("connectionLost");
                    }

                    @Override
                    public void messageArrived(String topic, MqttMessage message) throws Exception {
                        System.out.println("topic:"+topic);
                        System.out.println("Qos:"+message.getQos());
                        System.out.println("message content:"+new String(message.getPayload()));

                    }

                    @Override
                    public void deliveryComplete(IMqttDeliveryToken token) {
                        System.out.println("deliveryComplete---------"+ token.isComplete());
                    }

                });
                client.connect(options);
                //订阅消息
                client.subscribe(TOPIC, qos);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
