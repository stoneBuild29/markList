package com.example.datatransferwork;

import com.example.datatransferwork.demos.web.PushOaUserVO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DataTransferWorkApplication {

    public static void main(String[] args) throws IOException {


        String filePath = "C:\\Users\\88888\\Desktop\\person.json";

        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
            ObjectMapper objectMapper = new ObjectMapper();

            // 注册 JavaTime 模块
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            List<Map<String, Object>> list = objectMapper.readValue(jsonString, new TypeReference<List<Map<String, Object>>>(){});

            // 遍历每个对象并删除 ip 字段
            for (Map<String, Object> map : list) {
                map.remove("ip");
                map.remove("ts");
            }

            // 将修改后的数据转换回 JSON 字符串
            String modifiedJsonString = objectMapper.writeValueAsString(list);
            System.out.println(modifiedJsonString);

            // 反序列化为 PushOaUserVO 对象列表
            List<PushOaUserVO> users = objectMapper.readValue(modifiedJsonString, new TypeReference<List<PushOaUserVO>>(){});
            users.forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
