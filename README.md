Version 1.0

Demo

import com.tzcacm.bean.Query;
import com.tzcacm.bean.Status;
import com.tzcacm.bean.User;
import com.tzcacm.judge.JudgeClient;
import com.tzcacm.judge.SimpleJudgeClient;

public class VirtualJudgeTest {
    public static void main(String[] args) {
        //create judging client
        JudgeClient judgeClient = SimpleJudgeClient.getJudgeClient();
        
        //new User instance
        User user = new User("tzcjudge", "tzcjudge");
        
        //new judging query,parameters are problemId,language,sourceCode
        Query query = new Query(1,Query.QUERY_LANGUAGE_C,"helloworld");
        
        Status status = null;
        try {
            int submitId = judgeClient.submitZju(user, query);
            status = judgeClient.getStatusZju(submitId, user);
            System.out.println(status);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("net is exception");
        }
    }
}


if(status.getJudgeStatus() == Status.JUDGE_STATUS_ACCEPT){
            System.out.println("Accept");
}