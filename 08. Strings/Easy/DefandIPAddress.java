public class DefandIPAddress {

    public static String defandIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(defandIPaddr(address));
    }
}
