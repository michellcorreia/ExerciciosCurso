package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		List<Post> list = new ArrayList<>();
		
		System.out.print("Quantos Posts serão feitos? ");
		int postQuantity = sc.nextInt();
		sc.nextLine();
		
		for(int i=0; i<postQuantity; i++) {
			System.out.println("-Post#" + (i+1) + "-");
			System.out.print("Moment: ");
			Date moment = sdf.parse(sc.nextLine());
			System.out.print("Title: ");
			String title = sc.nextLine();
			System.out.print("Content: ");
			String content = sc.nextLine();
			System.out.print("Likes: ");
			Integer likes = sc.nextInt();
			sc.nextLine();
			Post post = new Post(moment, title, content, likes);
			
			System.out.println("");
			System.out.print("How many comments on that post? ");
			Integer commentQuantity = sc.nextInt();
			sc.nextLine();
			for(int x=0; x<commentQuantity; x++) {
				System.out.println("Comment #" + (x+1));
				String text = sc.nextLine();
				Comment comment = new Comment(text);
				post.addComment(comment);
			}
			
			System.out.println("");
			list.add(post);
		}
		
		for(Post x: list) {
			System.out.println(x);
		}
		
		sc.close();
	}
}
