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

/** This is an auto generated class representing the Exercise type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Exercises", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Exercise implements Model {
  public static final QueryField ID = field("Exercise", "id");
  public static final QueryField EXERCISE_NAME = field("Exercise", "exercise_name");
  public static final QueryField CATEGORY_NAME = field("Exercise", "category_name");
  public static final QueryField TARGET_MUSCLES = field("Exercise", "target_muscles");
  public static final QueryField TOOLS = field("Exercise", "tools");
  public static final QueryField NUM_SETS = field("Exercise", "num_sets");
  public static final QueryField NUM_REPS = field("Exercise", "num_reps");
  public static final QueryField DURATION = field("Exercise", "duration");
  public static final QueryField EXERCISE_CATEGORY_ID = field("Exercise", "exerciseCategoryId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String exercise_name;
  private final @ModelField(targetType="String", isRequired = true) String category_name;
  private final @ModelField(targetType="String") List<String> target_muscles;
  private final @ModelField(targetType="String") List<String> tools;
  private final @ModelField(targetType="Int") Integer num_sets;
  private final @ModelField(targetType="Int") Integer num_reps;
  private final @ModelField(targetType="Int") Integer duration;
  private final @ModelField(targetType="Category") @HasOne(associatedWith = "id", type = Category.class) Category Category = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  private final @ModelField(targetType="ID") String exerciseCategoryId;
  public String getId() {
      return id;
  }
  
  public String getExerciseName() {
      return exercise_name;
  }
  
  public String getCategoryName() {
      return category_name;
  }
  
  public List<String> getTargetMuscles() {
      return target_muscles;
  }
  
  public List<String> getTools() {
      return tools;
  }
  
  public Integer getNumSets() {
      return num_sets;
  }
  
  public Integer getNumReps() {
      return num_reps;
  }
  
  public Integer getDuration() {
      return duration;
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
  
  public String getExerciseCategoryId() {
      return exerciseCategoryId;
  }
  
  private Exercise(String id, String exercise_name, String category_name, List<String> target_muscles, List<String> tools, Integer num_sets, Integer num_reps, Integer duration, String exerciseCategoryId) {
    this.id = id;
    this.exercise_name = exercise_name;
    this.category_name = category_name;
    this.target_muscles = target_muscles;
    this.tools = tools;
    this.num_sets = num_sets;
    this.num_reps = num_reps;
    this.duration = duration;
    this.exerciseCategoryId = exerciseCategoryId;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Exercise exercise = (Exercise) obj;
      return ObjectsCompat.equals(getId(), exercise.getId()) &&
              ObjectsCompat.equals(getExerciseName(), exercise.getExerciseName()) &&
              ObjectsCompat.equals(getCategoryName(), exercise.getCategoryName()) &&
              ObjectsCompat.equals(getTargetMuscles(), exercise.getTargetMuscles()) &&
              ObjectsCompat.equals(getTools(), exercise.getTools()) &&
              ObjectsCompat.equals(getNumSets(), exercise.getNumSets()) &&
              ObjectsCompat.equals(getNumReps(), exercise.getNumReps()) &&
              ObjectsCompat.equals(getDuration(), exercise.getDuration()) &&
              ObjectsCompat.equals(getCreatedAt(), exercise.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), exercise.getUpdatedAt()) &&
              ObjectsCompat.equals(getExerciseCategoryId(), exercise.getExerciseCategoryId());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getExerciseName())
      .append(getCategoryName())
      .append(getTargetMuscles())
      .append(getTools())
      .append(getNumSets())
      .append(getNumReps())
      .append(getDuration())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .append(getExerciseCategoryId())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Exercise {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("exercise_name=" + String.valueOf(getExerciseName()) + ", ")
      .append("category_name=" + String.valueOf(getCategoryName()) + ", ")
      .append("target_muscles=" + String.valueOf(getTargetMuscles()) + ", ")
      .append("tools=" + String.valueOf(getTools()) + ", ")
      .append("num_sets=" + String.valueOf(getNumSets()) + ", ")
      .append("num_reps=" + String.valueOf(getNumReps()) + ", ")
      .append("duration=" + String.valueOf(getDuration()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()) + ", ")
      .append("exerciseCategoryId=" + String.valueOf(getExerciseCategoryId()))
      .append("}")
      .toString();
  }
  
  public static ExerciseNameStep builder() {
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
  public static Exercise justId(String id) {
    return new Exercise(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      exercise_name,
      category_name,
      target_muscles,
      tools,
      num_sets,
      num_reps,
      duration,
      exerciseCategoryId);
  }
  public interface ExerciseNameStep {
    CategoryNameStep exerciseName(String exerciseName);
  }
  

  public interface CategoryNameStep {
    BuildStep categoryName(String categoryName);
  }
  

  public interface BuildStep {
    Exercise build();
    BuildStep id(String id);
    BuildStep targetMuscles(List<String> targetMuscles);
    BuildStep tools(List<String> tools);
    BuildStep numSets(Integer numSets);
    BuildStep numReps(Integer numReps);
    BuildStep duration(Integer duration);
    BuildStep exerciseCategoryId(String exerciseCategoryId);
  }
  

  public static class Builder implements ExerciseNameStep, CategoryNameStep, BuildStep {
    private String id;
    private String exercise_name;
    private String category_name;
    private List<String> target_muscles;
    private List<String> tools;
    private Integer num_sets;
    private Integer num_reps;
    private Integer duration;
    private String exerciseCategoryId;
    @Override
     public Exercise build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Exercise(
          id,
          exercise_name,
          category_name,
          target_muscles,
          tools,
          num_sets,
          num_reps,
          duration,
          exerciseCategoryId);
    }
    
    @Override
     public CategoryNameStep exerciseName(String exerciseName) {
        Objects.requireNonNull(exerciseName);
        this.exercise_name = exerciseName;
        return this;
    }
    
    @Override
     public BuildStep categoryName(String categoryName) {
        Objects.requireNonNull(categoryName);
        this.category_name = categoryName;
        return this;
    }
    
    @Override
     public BuildStep targetMuscles(List<String> targetMuscles) {
        this.target_muscles = targetMuscles;
        return this;
    }
    
    @Override
     public BuildStep tools(List<String> tools) {
        this.tools = tools;
        return this;
    }
    
    @Override
     public BuildStep numSets(Integer numSets) {
        this.num_sets = numSets;
        return this;
    }
    
    @Override
     public BuildStep numReps(Integer numReps) {
        this.num_reps = numReps;
        return this;
    }
    
    @Override
     public BuildStep duration(Integer duration) {
        this.duration = duration;
        return this;
    }
    
    @Override
     public BuildStep exerciseCategoryId(String exerciseCategoryId) {
        this.exerciseCategoryId = exerciseCategoryId;
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
    private CopyOfBuilder(String id, String exerciseName, String categoryName, List<String> targetMuscles, List<String> tools, Integer numSets, Integer numReps, Integer duration, String exerciseCategoryId) {
      super.id(id);
      super.exerciseName(exerciseName)
        .categoryName(categoryName)
        .targetMuscles(targetMuscles)
        .tools(tools)
        .numSets(numSets)
        .numReps(numReps)
        .duration(duration)
        .exerciseCategoryId(exerciseCategoryId);
    }
    
    @Override
     public CopyOfBuilder exerciseName(String exerciseName) {
      return (CopyOfBuilder) super.exerciseName(exerciseName);
    }
    
    @Override
     public CopyOfBuilder categoryName(String categoryName) {
      return (CopyOfBuilder) super.categoryName(categoryName);
    }
    
    @Override
     public CopyOfBuilder targetMuscles(List<String> targetMuscles) {
      return (CopyOfBuilder) super.targetMuscles(targetMuscles);
    }
    
    @Override
     public CopyOfBuilder tools(List<String> tools) {
      return (CopyOfBuilder) super.tools(tools);
    }
    
    @Override
     public CopyOfBuilder numSets(Integer numSets) {
      return (CopyOfBuilder) super.numSets(numSets);
    }
    
    @Override
     public CopyOfBuilder numReps(Integer numReps) {
      return (CopyOfBuilder) super.numReps(numReps);
    }
    
    @Override
     public CopyOfBuilder duration(Integer duration) {
      return (CopyOfBuilder) super.duration(duration);
    }
    
    @Override
     public CopyOfBuilder exerciseCategoryId(String exerciseCategoryId) {
      return (CopyOfBuilder) super.exerciseCategoryId(exerciseCategoryId);
    }
  }
  
}
