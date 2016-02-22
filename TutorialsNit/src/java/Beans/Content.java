/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Timestamp;

/**
 *
 * @author shashank
 */
public class Content {
    private String title;
    private String content;
    private int rating;
    private int complexity;
    private Timestamp submittedOn;
    private Timestamp lastModifiedOn;
    private String authorName;
    private int authorId;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @return the complexity
     */
    public int getComplexity() {
        return complexity;
    }

    /**
     * @param complexity the complexity to set
     */
    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    /**
     * @return the submittedOn
     */
    public Timestamp getSubmittedOn() {
        return submittedOn;
    }

    /**
     * @param submittedOn the submittedOn to set
     */
    public void setSubmittedOn(Timestamp submittedOn) {
        this.submittedOn = submittedOn;
    }

    /**
     * @return the lastModifiedOn
     */
    public Timestamp getLastModifiedOn() {
        return lastModifiedOn;
    }

    /**
     * @param lastModifiedOn the lastModifiedOn to set
     */
    public void setLastModifiedOn(Timestamp lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    /**
     * @return the authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName the authorName to set
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * @return the authorId
     */
    public int getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId the authorId to set
     */
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
