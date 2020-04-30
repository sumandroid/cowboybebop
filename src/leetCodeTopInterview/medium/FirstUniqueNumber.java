package leetCodeTopInterview.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FirstUniqueNumber {
    public Set<Integer> set = new HashSet<>();
    private DoubleLinkedList doubleLinkedList;
    private Map<Integer, Node> map = new HashMap<>();

    public FirstUniqueNumber(int[] nums) {
        doubleLinkedList = new DoubleLinkedList();
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                Node node = doubleLinkedList.add(nums[i]);
                set.add(nums[i]);
                map.put(nums[i], node);
            }else{
                Node node = map.get(nums[i]);
                if(node != null){
                    doubleLinkedList.remove(node);
                    map.remove(nums[i]);
                }
            }
        }
    }

    public int showFirstUnique() {
        return this.doubleLinkedList.head.next.val;
    }

    public void add(int value) {
        if(!set.contains(value)){
            Node node = doubleLinkedList.add(value);
            map.put(value, node);
            set.add(value);
        }else{
            Node node = map.get(value);
            if(node != null){
                doubleLinkedList.remove(node);
                map.remove(value);
            }
        }
    }

    private static class DoubleLinkedList{
        private static Node head;
        private static Node tail;

        public DoubleLinkedList(){
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }

        public Node add(int val){
            Node temp = tail.prev;
            Node newNode = new Node(val);
            tail.prev = newNode;
            newNode.next = tail;
            newNode.prev = temp;
            temp.next = newNode;
            return newNode;
        }

        public void remove(Node node){
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.next = null;
            node.prev = null;
        }
    }

    private static class Node{
        private int val;
        private Node next;
        private Node prev;

        public Node(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public static void main(String []args){
        int[] nums = new int[]{392,59,691,331,805,15,180,248,114,62,643,401,316,764,793,234,821,304,441,905,983,815,38,560,526,259,995,343,165,648,995,945,401,414,44,16,224,423,933,452,152,893,116,570,343,317,263,311,600,928,573,859,540,739,244,994,409,429,892,277,413,481,88,445,744,706,971,136,233,250,584,619,439,316,601,120,245,252,187,844,48,139,412,778,316,929,8,182,839,868,15,793,31,733,987,69,212,319,594,485,955,598,543,68,947,719,552,763,520,543,487,62,740,694,293,52,599,998,414,479,292,954,195,846,143,384,186,113,490,956,64,708,654,701,297,187,236,514,607,409,462,427,87,503,566,835,17,327,395,4,87,605,24,293,141,648,62,919,749,291,760,322,84,274,306,734,495,550,925,434,848,869,873,904,442,772,858,9,729,956,85,404,882,305,674,172,398,582,915,428,475,516,459,939,239,673,837,227,262,921,506,8,110,122,294,187,964,941,168,380,803,698,886,361,464,1,162,30,955,264,225,347,302,553,771,492,2,694,764,147,608,620,455,378,367,306,303,5,306,467,973,233,579,923,965,137,586,499,896,941,372,854,483,794,610,746,751,64,106,229,939,966,40,962,75,27,136,215,687,439,414,416,564,963,789,171,364,229,327,77,31,493,900,972,639,355,262,832,315,148,824,559,763,320,76,802,882,685,399,63,843,304,551,710,774,519,275,883,204,576,387,808,709,912,363,99,82,959,626,304,604,716,273,468,807,352,379,708,246,825,638,434,974,402,153,46,275,946,883,202,37,925,649,431,562,310,445,713,578,521,814,616,670,963,667,852,984,813,168,969,270,729,877,795,232,908,402,312,431,946,386,463,692,458,93,330,492,390,619,819,573,903,147,363,354,625,783,358,991,292,476,757,660,83,872,523,135,750,835,793,749,777,740,665,993,779,259,921,215,551,838,244,47,976,782,907,63,448,945,115,730,180,423,895,909,407,138,955,282,919,429,894,935,124,469,459,503,135,667,530,543,60,157,600,947,792,417,528,349,622,285,738,575,48,885,809,661,405,965,923,721,209,582,587,185,825,974,67,349,745,953,2,628,404,226,165,299,811,366,935,215,440,196,218,348,266,810,565,126,988,520,855,305,255,72,987,714,496,159,673,268,645,658,572,600,898,166,942,431,864,373,702,201,257,14,588,483,730,870,610,804,106,315,780,204,986,223,259,442,333,690,504,492,874,344,73,391,56,797,852,581,879,40,12,792,802,940,696,562,312,165,306,391,241,410,284,248,296,89,682,238,262,647,245,257,23,389,451,227,270,635,401,589,268,839,94,279,973,827,657,129,699,674,142,304,682,515,688,173,413,788,766,189,239,864,80,516,488,129,662,294,138,714,772,970,239,704,51,358,916,975,653};
        FirstUniqueNumber obj = new FirstUniqueNumber(nums);
        System.out.println(obj.showFirstUnique());
        obj.add(7);
        obj.add(3);
        obj.add(3);
        obj.add(7);
        obj.add(17);
        System.out.println(obj.showFirstUnique());
    }
}
