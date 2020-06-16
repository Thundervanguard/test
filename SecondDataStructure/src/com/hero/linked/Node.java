package com.hero.linked;


public class Node {

    //英雄排名
    private Integer id;

    //英雄名字
    private String name;

    //英雄昵称
    private String nickName;

    private Node next;

    private Node pre;

    public Node(Integer id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
