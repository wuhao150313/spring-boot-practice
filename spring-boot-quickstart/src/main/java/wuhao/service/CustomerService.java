package wuhao.service;


import org.springframework.stereotype.Service;
import wuhao.enums.RequestType;

@Service
public class CustomerService {

    public String handleRequest(RequestType requestType) {
       return switch (requestType){
            case QUERY ->handleQuery();

            case COMPLAINT ->handleComplaint();

            case SUGGESTION ->handleSuggestion();

        };
    }

    public String handleQuery(){
        return "查询请求";
    }

    public String handleComplaint(){
        return "投诉请求";
    }

    public String handleSuggestion(){
        return "建议请求";
    }
}
