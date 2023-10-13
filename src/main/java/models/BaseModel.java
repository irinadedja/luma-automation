package models;

import com.github.javafaker.Faker;

public abstract class BaseModel {
   protected Faker faker = new Faker();

   public abstract void generate();
}
