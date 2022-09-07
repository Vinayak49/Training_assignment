package com.hotwax.www;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;

public class Problem_statement_1 {
    public static void main(String[] args) {
//        String[] a = new String[3];
        ArrayList<String> a = new ArrayList<>();
        try {
            File obj1 = new File("url.txt");
            Scanner r = new Scanner(obj1);
            File file = new  File("words.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                a.add(sc.nextLine());
            }
            Collections.sort(a);
            while (r.hasNextLine()) {
                String data = r.nextLine();
                URL x = new URL(data);
                BufferedReader in = new BufferedReader(new InputStreamReader(x.openStream()));
                String inputLine;

                int v=0,w=0,y=0;
                HashMap<String, Integer> map = new HashMap<>();
                int count=0;
                int count1=0;
                int count2=0;
                while ((inputLine = in.readLine()) != null) {

                    String result = inputLine.replaceAll("<[^>]*>", "");
                     count = (result.split(a.get(0)).length) - 1;
                     count1 = (result.split(a.get(1)).length) - 1;
                     count2 = (result.split(a.get(2)).length) - 1;
                    v += count;
                    w += count1;
                    y += count2;
                }
                map.put(a.get(0),v);
                map.put(a.get(1),w);
                map.put(a.get(2),y);
                System.out.println("For the url : " + x);
                LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
                ArrayList<Integer> list = new ArrayList<>();
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    list.add(entry.getValue());
                }
                Collections.sort(list, Collections.reverseOrder());
                for (int num : list) {
                    for (Entry<String, Integer> entry : map.entrySet()) {
                        if (entry.getValue().equals(num)) {
                            sortedMap.put(entry.getKey(), num);
                        }
                    }
                }
                System.out.println(sortedMap);

                in.close();
            }
            r.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
