import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    
    static final int UNION = 0;
    static final int CHECK = 1;
    
    //0이 나올 경우 합친다. 

    //1이 나올 경우 같은 집합에 있는지 확인한다. 

    static int n; // 정수의 개수 
    static int m; // 연산의 횟수 


    static int[] parents; 

    static int find(int a){
        if(a==parents[a]){
            return a; 
        }

        return parents[a] = find(parents[a]);
    }

    static void union(int a, int b){
        int pA = find(a);
        int pB = find(b); 

        parents[pA] = pB;
    }

    static void init() throws IOException{
        tokens = new StringTokenizer(buffer.readLine()); 
        n = Integer.valueOf(tokens.nextToken());
        m = Integer.valueOf(tokens.nextToken()); 
        
        parents = new int[n+1];
        
        for(int i=1; i<=n; i++) {
        	parents[i] = i;
        }
    }

    public static void main(String[] args)throws IOException{
        init(); 
        
        StringBuilder log = new StringBuilder();
        for(int i=0; i<m; i++) {
        	tokens = new StringTokenizer(buffer.readLine()); 
        	
        	int opt = Integer.valueOf(tokens.nextToken());
        	int a =Integer.valueOf(tokens.nextToken());
        	int b =Integer.valueOf(tokens.nextToken());
        	if(opt==UNION) {
        		union(a,b);
        	}else if(opt==CHECK) {
        		if(find(a)==find(b)) {
        			log.append(1).append("\n");
        		}else {
        			log.append(0).append("\n");
        		}
        	}

        }
      System.out.println(log);

    }
}


import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

class UserSolution
{
    private static final int ARTICLE = 0;
    private static final int COMMENT = 1;
    private static final int REPLY = 2;


    private static Map<String, User> idToUsers;
    private static TreeSet<User> bestUsers;

    private static Map<Integer, Message> idToArticles;
    private static TreeSet<Message>  bestArticles;

    private static Map<Integer, Message> comments;

    private static Map<Integer, List<Message>> relatedComments;
    private static Map<Integer, List<Message>> relatedReplies;

    public void init()
    {
        return;
    }

    //모든 케이스는 5*10^4회 이하
    //사용자 수 10^4
    //글 또는 댓글의 ID 10^9


    //유저 점수 -> 사용자가 작성한 글 + 댓글 + 답글 포인트 (삭제된 글, 댓글, 답글의 포인트는 포함하지 않는다.)
    //글 점수 -> 원래 글 포인트 + 글에 달린 댓글과 답글 포인트 총합 (삭제된 댓글과 답글은 고려하지 않는다. )

    //유저의 점수 갱신 (id, point)
        //idToUsers에서 id로 조회한다.
        //bestUsers에서 삭제한다.
        //포인트를 갱신한다.
        //bestUsers에 다시 넣는다.


    public int writeMessage(char[] mUser, int mID, int mPoint)
    {
        //mUser 사용자가 mId, mPoint인 글을 작성하고 등록
        //게시글 작성
            //idToArticles에 넣는다.

        //게시글 작성자 점수 증가
            //idToUsers에 있는지 확인한다.
                //있다면 점수를 갱신한다.
                //없다면 새로운 유저를 넣어 갱신한다.


        //mUser 사용자의 총합 포인트를 반환한다.
            //작성한 글, 댓글, 답글의 포인트를 모두 합한 값

        return -1;
    }

    public int commentTo(char[] mUser, int mID, int mTarget, int mPoint)
    {
        //mUser 사용자가 mTargetID인 글 또는 댓글에 mID 댓글 또는 답글을 작성한다.

        //targetId가 글인지 댓글인지 확인
            //댓글을 등록하는 경우
                //게시글과 댓글 관계 표시
                    //relatedComments에 등록한다.
                //댓글을 등록한다.
                    //comments에 등록한다.
                //댓글 작성자의 포인트를 갱신한다.
                    //작성자 id로 idToUser에서 유저를 조회한다.
                        //idToArticles와 bestArticles를 활용해 게시글 포인트를 갱신한다.
                //댓글의 게시글 포인트를 갱신한다.
                    //타겟 id로 게시글을 조회한다.
                        //idToArticles와 bestArticles를 활용해 게시글 포인트를 갱신한다.
            //답글을 등록하는 경우
                //답글을 등록한다.
                    //replies에 등록한다.
                //답글 작성자의 포인트를 갱신한다.
                    //답글 객체에서 작성자를 가지고 온다.
                        //idToUsers와 bestUsers를 이용해서 답글을 갱신한다.
                //해당 답글의 댓글의 게시글 포인트를 갱신한다.
                    //targetId를 가지고온다.
                    //comments에서 답글의 댓글을 가지고 온다.
                    //가져온 객체에서 게시글 id을 찾는다.
                        //idToArticles와 bestArticles를 활용해 게시글 포인트를 갱신한다.


        //게시글의 총합 포인트를 반환한다.
        return -1;
    }

    public int erase(int mID)
    {

        //글 또는 댓글 또는 답글을 삭제한다.

            //글을 삭제한 경우
                //글에 달린 댓글과 답글이 모두 삭제 된다.
                    //댓글을 삭제한다.
                        //relatedComments에서 댓글 목록을 가져온다. relatedComments
                            //relatedReplies에서 답글 목록을 가져온다.
                                //답글 작성자의 점수를 갱신한다.
                        //댓글을 삭제한다.
                            //relatedComments에서 게시글 id로 삭제한다.
                            //comments에서 삭제한다.
                            //댓글 작성자의 점수를 갱신한다.
                    //게시글을 삭제한다.

            //댓글을 삭제한 경우
                //relatedReplies에서 답글 목록을 가져온다.
                    //답글 작성자의 점수를 갱신한다.
                //댓글을 삭제한다.
                    //relatedComments에서 게시글 id로 조회하여 삭제한다.

        return -1;
    }

    public void getBestMessages(int[] mBestMessageList)
    {
        //총합 포인트가 가장 높은 5개의 글 반환
        return;
    }

    public void getBestUsers(char[][] mBestUserList)
    {
        //총합 포인트가 가장 높은 5명의 사용자 반환
        return;
    }
}

class User implements Comparable<User>{
    String id;
    long score;


    @Override
    public int compareTo(User o) {
        if(this.score == o.score){
            return this.id.compareTo(o.id);
        }
        return Long.compare(o.score, this.score);
    }


    public User(String id, long score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return score == user.score && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, score);
    }
}

class Message implements Comparable<Message>{

    int id;
    long point;
    long originalPoint;
    int type;
    int targetId;
    String writer;

    static String[] types = {"게시글", "댓글", "답글"};

    public Message(int id, long point, int type, int targetId, String writer) {
        this.id = id;
        this.point = point;
        this.originalPoint = point;
        this.type = type;
        this.targetId = targetId;
        this.writer = writer;
    }


    @Override
    public int compareTo(Message o) {
        if(o.point == this.point){
            return this.id-o.id;
        }

        return Long.compare(o.point, this.point);
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", point=" + point +
                ", originalPoint=" + originalPoint +
                ", type=" + types[type] +
                ", targetId=" + targetId +
                ", writer='" + writer + '\'' +
                '}';
    }
}
