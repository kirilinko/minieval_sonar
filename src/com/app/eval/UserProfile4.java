public class UserProfile4 {
    public static void main(String[] args) {
        String username = "<script>alert('XSS')</script>";

        System.out.println("<html><body>");
        System.out.println("<h1>Bienvenue " + username + "</h1>");
        System.out.println("</body></html>");
    }
}