package Stack;

class SolutionOpenTheLock {
    
}

class TestOpenTheLock {
    public static void main(String args[]){
        String node = "0000";
        for (int i = 0; i < 4; ++i) {
            for (int d = -1; d <= 1; d += 2) {
                int y = ((node.charAt(i) - '0') + d + 10) % 10;
                //String nei = node.substring(0, i) + ("" + y) + node.substring(i+1);
                //System.out.println(nei);
                /*if (!seen.contains(nei)) {
                    seen.add(nei);
                    queue.offer(nei);
                }*/
            }
        }

        int value = 1234;
        int pow = 1;
        for (int i = 0; i < 4; ++i) {
            int d = value % 10;
            int increase = (d + 10 + 1) % 10;
            int decrease = (d + 10 - 1) % 10;
            value /= 10;
            System.out.println("D "+d*pow);
            System.out.println("increase "+increase);
            System.out.println("decrease "+decrease);
            pow *= 10;
            
            
        }
    }
}