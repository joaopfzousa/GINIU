package edu.ufp.inf.lp2_aed2;

import java.io.Serializable;

public abstract class Person implements Serializable {
  /**
   * Atributos
   */
  private Integer id;

  private String name;

  private String email;

  /**
   * Construtor
   * @param id
   * @param name
   * @param email
   */
  public Person(Integer id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  /**
   * toString
   * @return
   */
  @Override
  public String toString() {
    return "Person{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  /**
   * Get's e Set's
   */
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  //public Vector  myPoint;
}