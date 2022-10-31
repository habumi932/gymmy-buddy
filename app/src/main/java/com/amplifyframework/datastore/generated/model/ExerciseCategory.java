package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the ExerciseCategory type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "ExerciseCategories")
@Index(name = "byCategory", fields = {"categoryID"})
@Index(name = "byExercise", fields = {"exerciseID"})
public final class ExerciseCategory implements Model {
  public static final QueryField ID = field("ExerciseCategory", "id");
  public static final QueryField CATEGORY = field("ExerciseCategory", "categoryID");
  public static final QueryField EXERCISE = field("ExerciseCategory", "exerciseID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Category", isRequired = true) @BelongsTo(targetName = "categoryID", type = Category.class) Category category;
  private final @ModelField(targetType="Exercise", isRequired = true) @BelongsTo(targetName = "exerciseID", type = Exercise.class) Exercise exercise;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public Category getCategory() {
      return category;
  }
  
  public Exercise getExercise() {
      return exercise;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private ExerciseCategory(String id, Category category, Exercise exercise) {
    this.id = id;
    this.category = category;
    this.exercise = exercise;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ExerciseCategory exerciseCategory = (ExerciseCategory) obj;
      return ObjectsCompat.equals(getId(), exerciseCategory.getId()) &&
              ObjectsCompat.equals(getCategory(), exerciseCategory.getCategory()) &&
              ObjectsCompat.equals(getExercise(), exerciseCategory.getExercise()) &&
              ObjectsCompat.equals(getCreatedAt(), exerciseCategory.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), exerciseCategory.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getCategory())
      .append(getExercise())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("ExerciseCategory {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("category=" + String.valueOf(getCategory()) + ", ")
      .append("exercise=" + String.valueOf(getExercise()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static CategoryStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static ExerciseCategory justId(String id) {
    return new ExerciseCategory(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      category,
      exercise);
  }
  public interface CategoryStep {
    ExerciseStep category(Category category);
  }
  

  public interface ExerciseStep {
    BuildStep exercise(Exercise exercise);
  }
  

  public interface BuildStep {
    ExerciseCategory build();
    BuildStep id(String id);
  }
  

  public static class Builder implements CategoryStep, ExerciseStep, BuildStep {
    private String id;
    private Category category;
    private Exercise exercise;
    @Override
     public ExerciseCategory build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new ExerciseCategory(
          id,
          category,
          exercise);
    }
    
    @Override
     public ExerciseStep category(Category category) {
        Objects.requireNonNull(category);
        this.category = category;
        return this;
    }
    
    @Override
     public BuildStep exercise(Exercise exercise) {
        Objects.requireNonNull(exercise);
        this.exercise = exercise;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, Category category, Exercise exercise) {
      super.id(id);
      super.category(category)
        .exercise(exercise);
    }
    
    @Override
     public CopyOfBuilder category(Category category) {
      return (CopyOfBuilder) super.category(category);
    }
    
    @Override
     public CopyOfBuilder exercise(Exercise exercise) {
      return (CopyOfBuilder) super.exercise(exercise);
    }
  }
  
}
