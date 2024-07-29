package org.SaveMoney;

import org.SaveMoney.Model.Model;

import java.io.*;

public class Config {

    public void Save(Model model){
        Long amount= Model.getAmount();
        Long goal= Model.getGoal();
        File configFile= new File("cfg.txt");
        try {
            if(configFile.createNewFile()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("cfg.txt"))) {
                    writer.write(String.valueOf(amount));
                    writer.write("\n");
                    writer.write(String.valueOf(goal));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("cfg.txt"))) {
                    writer.write(String.valueOf(amount));
                    writer.write("\n");
                    writer.write(String.valueOf(goal));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Model Load(){
        long amount=0;
        long goal=0;
        try(BufferedReader br=new BufferedReader(new FileReader("cfg.txt"))){
            String line=br.readLine();
            amount=Long.parseLong(line);
            line=br.readLine();
            goal=Long.parseLong(line);
        }catch (IOException e){
            e.printStackTrace();
        }
        return new Model(amount,goal);
    }


}
