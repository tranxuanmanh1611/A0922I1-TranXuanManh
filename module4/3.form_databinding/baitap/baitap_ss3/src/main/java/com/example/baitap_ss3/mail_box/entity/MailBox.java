package com.example.baitap_ss3.mail_box.entity;

import javax.persistence.*;

@Entity
public class MailBox {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

   private int emailPerPage;
   private boolean spamFilter;
   @Column(name = "signature",columnDefinition = "nvarchar(100)")
   private String signature;

   @ManyToOne
   @JoinColumn(name = "language_id",referencedColumnName = "language_id")
   private Language language;

   public MailBox() {
   }

   public MailBox(Language language, int emailPerPage, boolean spamFilter, String signature) {
      this.language=language;
      this.emailPerPage = emailPerPage;
      this.spamFilter = spamFilter;
      this.signature = signature;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getEmailPerPage() {
      return emailPerPage;
   }

   public void setEmailPerPage(int emailPerPage) {
      this.emailPerPage = emailPerPage;
   }

   public boolean isSpamFilter() {
      return spamFilter;
   }

   public void setSpamFilter(boolean spamFilter) {
      this.spamFilter = spamFilter;
   }

   public String getSignature() {
      return signature;
   }

   public void setSignature(String signature) {
      this.signature = signature;
   }

   public Language getLanguage() {
      return language;
   }

   public void setLanguage(Language language) {
      this.language = language;
   }
}
