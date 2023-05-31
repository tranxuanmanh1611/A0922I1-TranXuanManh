package com.example.baitap_ss3.mail_box.entity;

public class MailBox {
   private String languages;
   private int emailPerPage;
   private String spamFilter;
   private String signature;

   public MailBox() {
   }

   public MailBox(String languages, int emailPerPage, boolean spamFilter, String signature) {
      this.languages = languages;
      this.emailPerPage = emailPerPage;
      if (spamFilter){
         this.spamFilter = "Active";
      }else {
         this.spamFilter = "Inactive";
      }
      this.signature = signature;
   }

   public String getLanguages() {
      return languages;
   }

   public void setLanguages(String languages) {
      this.languages = languages;
   }

   public int getEmailPerPage() {
      return emailPerPage;
   }

   public void setEmailPerPage(int emailPerPage) {
      this.emailPerPage = emailPerPage;
   }

   public String isSpamFilter() {
      return spamFilter;
   }

   public void setSpamFilter(String spamFilter) {
      this.spamFilter = spamFilter;
   }

   public String getSignature() {
      return signature;
   }

   public void setSignature(String signature) {
      this.signature = signature;
   }
}
