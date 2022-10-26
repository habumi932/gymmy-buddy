package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasOne;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Muscle type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Muscles", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ }),
  @AuthRule(allow = AuthStrategy.PRIVATE, operations = { ModelOperation.READ })
})
@Index(name = "byExercise", fields = {"exerciseID"})
public final class Muscle implements Model {
  public static final QueryField ID = field("Muscle", "id");
  public static final QueryField MUSCLE_NAME = field("Muscle", "muscleName");
  public static final QueryField EXERCISE_ID = field("Muscle", "exerciseID");
  public static final QueryField MUSCLE_CATEGORY_ID = field("Muscle", "muscleCategoryId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String muscleName;
  private final @ModelField(targetType="ID", isRequired = true) String exerciseID;
  private final @ModelField(targetType="Category") @HasOne(associatedWith = "id", type = Category.class) Category Category = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  private final @ModelField(targetType="ID") String muscleCategoryId;
  public String getId() {
      return id;
  }
  
  public String getMuscleName() {
      return muscleName;
  }
  
  public String getExerciseId() {
      return exerciseID;
  }
  
  public Category getCategory() {
      return Category;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  public String getMuscleCategoryId() {
      return muscleCategoryId;
  }
  
  private Muscle(String id, String muscleName, String exerciseID, String muscleCategoryId) {
    this.id = id;
    this.muscleName = muscleName;
    this.exerciseID = exerciseID;
    this.muscleCategoryId = muscleCategoryId;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Muscle muscle = (Muscle) obj;
      return ObjectsCompat.equals(getId(), muscle.getId()) &&
              ObjectsCompat.equals(getMuscleName(), muscle.getMuscleName()) &&
              ObjectsCompat.equals(getExerciseId(), muscle.getExerciseId()) &&
              ObjectsCompat.equals(getCreatedAt(), muscle.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), muscle.getUpdatedAt()) &&
              ObjectsCompat.equals(getMuscleCategoryId(), muscle.getMuscleCategoryId());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getMuscleName())
      .append(getExerciseId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .append(getMuscleCategoryId())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Muscle {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("muscleName=" + String.valueOf(getMuscleName()) + ", ")
      .append("exerciseID=" + String.valueOf(getExerciseId()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()) + ", ")
      .append("muscleCategoryId=" + String.valueOf(getMuscleCategoryId()))
      .append("}")
      .toString();
  }
  
  public static ExerciseIdStep builder() {
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
  public static Muscle justId(String id) {
    return new Muscle(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      muscleName,
      exerciseID,
      muscleCategoryId);
  }
  public interface ExerciseIdStep {
    BuildStep exerciseId(String exerciseId);
  }
  

  public interface BuildStep {
    Muscle build();
    BuildStep id(String id);
    BuildStep muscleName(String muscleName);
    BuildStep muscleCategoryId(String muscleCategoryId);
  }
  

  public static class Builder implements ExerciseIdStep, BuildStep {
    private String id;
    private String exerciseID;
    private String muscleName;
    private String muscleCategoryId;
    @Override
     public Muscle build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Muscle(
          id,
          muscleName,
          exerciseID,
          muscleCategoryId);
    }
    
    @Override
     public BuildStep exerciseId(String exerciseId) {
        Objects.requireNonNull(exerciseId);
        this.exerciseID = exerciseId;
        return this;
    }
    
    @Override
     public BuildStep muscleName(String muscleName) {
        this.muscleName = muscleName;
        return this;
    }
    
    @Override
     public BuildStep muscleCategoryId(String muscleCategoryId) {
        this.muscleCategoryId = muscleCategoryId;
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
    private CopyOfBuilder(String id, String muscleName, String exerciseId, String muscleCategoryId) {
      super.id(id);
      super.exerciseId(exerciseId)
        .muscleName(muscleName)
        .muscleCategoryId(muscleCategoryId);
    }
    
    @Override
     public CopyOfBuilder exerciseId(String exerciseId) {
      return (CopyOfBuilder) super.exerciseId(exerciseId);
    }
    
    @Override
     public CopyOfBuilder muscleName(String muscleName) {
      return (CopyOfBuilder) super.muscleName(muscleName);
    }
    
    @Override
     public CopyOfBuilder muscleCategoryId(String muscleCategoryId) {
      return (CopyOfBuilder) super.muscleCategoryId(muscleCategoryId);
    }
  }
  
}
