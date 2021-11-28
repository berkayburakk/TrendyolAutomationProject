package apiBuilder;

import java.util.HashMap;
import java.util.Map;

public class GetAPIBuilder {

    public Map<String,String> getSampleSearchRequest(String keyword){

        Map<String,String> params = new HashMap<String,String>();
        params.put("q",keyword);
        params.put("qt",keyword);
        params.put("st",keyword);
        params.put("os","1");
        return params;
    }

    public Map<String,String> getEmptyRequest(){
        Map<String,String> params = new HashMap<>();
        return params;
    }
}
