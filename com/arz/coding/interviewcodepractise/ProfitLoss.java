package com.arz.coding.interviewcodepractise;

public class ProfitLoss {
    private int id;
    private String name;

    ProfitLoss(ProfitLossBuilder profitLossBuilder){
        this.id = profitLossBuilder.id;
        this.name = profitLossBuilder.name;
    }

    public static final class ProfitLossBuilder{
       private int id;
       private String name;

       public ProfitLossBuilder setId(int id){
           this.id = id;
           return this;
       }
       public ProfitLossBuilder setName(String name){
           this.name = name;
           return this;
       }

       public static ProfitLossBuilder builder(){
           return  new ProfitLossBuilder();
       }

       public ProfitLoss build(){
           return new ProfitLoss(this);
       }
    }
}

// return ProfitLoss.builder.setId(1).build();
