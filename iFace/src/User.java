package entities;
import java.time.LocalDateTime;


public class User extends Comment{
    
    private String email;
    private String password;
    private String name;
    private String birthdate;
    private String relationship;
    
    
    private List<Post> posts;
    private List<Follow> followers;
    
    LocalDateTime now = LocalDateTime.now();

    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String date = formatterData.format(now);

    DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    String time = formatterHora.format(now);
    
    public User() {
	super();
    }
    
    public User(String email, String password, String name, String birthdate, String relationship) {
	super();
	this.email = email;
	this.password = password;
	this.name = name;
        this.birthdate = birthdate;
	this.relationship = relationship;
        this.posts = new ArrayList<>();
	this.followers = new ArrayList<>();
    }
    
     public User(String name, String birthdate, String relationship) {
	this.name = name;
	this.birthdate = birthdate;
	this.relationship = relationship;
        this.posts = new ArrayList<>();
	this.followers = new ArrayList<>();
     }
     
     public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email =  email;
    }
    
    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getBirthdate() {
	return birthdate;
    }

    public void setBirthdate(String birthdate) {
	this.birthdate = birthdate;
    }

    public String getRelationship() {
	return relationship;
    }

    public void setRelationship(String relationship) {
	this.relationship = relationship;
    }
    
    public List<Post> getPosts() {
	return posts;
    }

    public List<Follow> getFollowers() {
	return followers;
    }
    
    // POSTS

    public void showPosts() {
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("                                                                  {TIMELINE}");
	for (int i = 0; i < posts.size(); i++) {
	    System.out.println();
	    System.out.println("Post #" + posts.get(i).getIdPost() + " by " + name + " on " + date + " at " + time);
	    System.out.println("        " + posts.get(i).getContent());
            System.out.println();
            posts.get(i).showComments();
            System.out.println();
	}
    }
    
    public void showYourPosts() {
	for (int i = 0; i < posts.size(); i++) {
	    System.out.println();
	    System.out.println("Post #" + posts.get(i).getIdPost() + " by " + name + " on " + date + " at " + time);
	    System.out.println("        " + posts.get(i).getContent());
	    System.out.println();
	}
    }
     
    public void addPost(User user, Integer idPost, String content) {
	posts.add(new Post(user, idPost, content));
    }
    
    public void editPost(Integer idPost, String content) {
	for (int i = 0; i < posts.size(); i++) {
	    if (posts.get(i).getIdPost() == idPost) {
		posts.get(i).setContent(content);
	    }
	}
    }
    
    public void removePost(Integer idPost) 
    {
	for (int i = 0; i < posts.size(); i++) 
        {
	    if (posts.get(i).getIdPost() == idPost) 
            {
		posts.remove(i);
	    }
	}
        System.out.println();
        System.out.println("Post deletado");
        System.out.println("_________________________________________________");
    }
    
    // friends
    
    public void showFollowers(){
        for(int i = 0; i < followers.size(); i++){
            System.out.println();
            System.out.println("#" + followers.gt(i).getName() + ", Birthday: "+ followers.get(i).getBirthdate() + ", Relationship status: " + followers.get(i).getRelationship());
            
        }
    }
    
    public void showFriends(){
        System.out.println("_____________________________________________-_____");
        System.out.println("                                            [AMIGOS]");
        for(int i = 0 ; i< followers.size(); i++)
        {
            System.out.println(followers.get(i).getName()+ " / ");
        }
        System.out.println();
    }
    
    public void follow(String name, String birthdate, String relationship){
        followers.add(new Follow(name, birthdate, relationship));
        System.out.println("AMIGO ADICIONADO");
    }
    
    public void unfollow(String nameFollower){
        for(int i =0; i<followers.size(); i++){
            if(followers.get(i).getName.contentEquals(nameFollower)){
                followers.remove(i);
                System.out.println("AMIGO REMOVIDO");
            }else{
                System.out.println("VOCE NÃO PODE REMOVER UM AMIGO COM ESSE NOME");
            }
        }
    }
        
   
}
