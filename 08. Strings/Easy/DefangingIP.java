package Strings;

class DefangingIP {

    // public static String defangIPaddr(String address) {
    //     String[] arr = address.split("[\\s.]");
    //     StringBuffer res = new StringBuffer();
    //     for(int i=0;i<arr.length;i++) {
    //         res.append(arr[i]);
    //         if(i!=arr.length-1) {
    //             res.append("[.]");
    //         }
    //     }
    //     return res.toString();
    // }

    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        String add = "1.1.1.1";
        System.out.println(defangIPaddr(add));
    }
    
}