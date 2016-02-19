package com.spoton.soliteapplication;

/**
 * Created by shashi on 1/13/16.
 */
public class DateProvider {
   private  String rno,name,add,clas,marks;


    public String getRno(){return rno;}
    public void setRno(String rno){ this.rno=rno; }

    public String getNam(){return name;}
    public void setNam(String name){ this.name=name; }

    public String getAdd(){return add;}
    public void setAdd(String add){ this.add=add; }

    public String getClas(){return clas;}
    public void setClas(String clas){ this.clas=clas; }

    public String getMarks(){return marks;}
    public void setMarks(String marks){ this.marks=marks; }

  public DateProvider(String rno,String name,String add,String clas,String marks) {
      this.rno = rno;
      this.name = name;
      this.add = add;
      this.clas = clas;
      this.marks = marks;
  }

}
