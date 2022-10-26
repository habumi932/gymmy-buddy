package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
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
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ }),
  @AuthRule(allow = AuthStrategy.PRIVATE, operations = { ModelOperation.READ })
})
public final class Exercise implements Model {
  public static final QueryField ID = field("Exercise", "id");
  public static final QueryField EXERCISE_NAME = field("Exercise", "exercise_name");
  public static final QueryField TOOLS = field("Exercise", "tools");
  public static final QueryField NUM_SETS = field("Exercise", "num_sets");
  public static final QueryField NUM_REPS = field("Exercise", "num_reps");
  public static final QueryField DURATION = field("Exercise", "duration");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String exercise_name;
  private final @ModelField(targetType="String") List<String> tools;
  private final @ModelField(targetType="Int") Integer num_sets;
  private final @ModelField(targetType="Int") Integer num_reps;
  private final @ModelField(targetType="Int") Integer duration;
  private final @ModelField(targetType="Muscle") @HasMany(associatedWith = "exerciseID", type = Muscle.class) List<Muscle> Muscles = null;
  private final @ModelField(targetType="Category") @HasMany(associatedWith = "exerciseID", type = Category.class) List<Category> Categories = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getExerciseName() {
      return exercise_name;
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
  
  public List<Muscle> getMuscles() {
      return Muscles;
  }
  
  public List<Category> getCategories() {
      return Categories;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Exercise(String id, String exercise_name, List<String> tools, Integer num_sets, Integer num_reps, Integer duration) {
    this.id = id;
    this.exercise_name = exercise_name;
    this.tools = tools;
    this.num_sets = num_sets;
    this.num_reps = num_reps;
    this.duration = duration;
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
              ObjectsCompat.equals(getTools(), exercise.getTools()) &&
              ObjectsCompat.equals(getNumSets(), exercise.getNumSets()) &&
              ObjectsCompat.equals(getNumReps(), exercise.getNumReps()) &&
              ObjectsCompat.equals(getDuration(), exercise.getDuration()) &&
              ObjectsCompat.equals(getCreatedAt(), exercise.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), exercise.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getExerciseName())
      .append(getTools())
      .append(getNumSets())
      .append(getNumReps())
      .append(getDuration())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Exercise {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("exercise_name=" + String.valueOf(getExerciseName()) + ", ")
      .append("tools=" + String.valueOf(getTools()) + ", ")
      .append("num_sets=" + String.valueOf(getNumSets()) + ", ")
      .append("num_reps=" + String.valueOf(getNumReps()) + ", ")
      .append("duration=" + String.valueOf(getDuration()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
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
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      exercise_name,
      tools,
      num_sets,
      num_reps,
      duration);
  }
  public interface ExerciseNameStep {
    BuildStep exerciseName(String exerciseName);
  }
  

  public interface BuildStep {
    Exercise build();
    BuildStep id(String id);
    BuildStep tools(List<String> tools);
    BuildStep numSets(Integer numSets);
    BuildStep numReps(Integer numReps);
    BuildStep duration(Integer duration);
  }
  

  public static class Builder implements ExerciseNameStep, BuildStep {
    private String id;
    private String exercise_name;
    private List<String> tools;
    private Integer num_sets;
    private Integer num_reps;
    private Integer duration;
    @Override
     public Exercise build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Exercise(
          id,
          exercise_name,
          tools,
          num_sets,
          num_reps,
          duration);
    }
    
    @Override
     public BuildStep exerciseName(String exerciseName) {
        Objects.requireNonNull(exerciseName);
        this.exercise_name = exerciseName;
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
    private CopyOfBuilder(String id, String exerciseName, List<String> tools, Integer numSets, Integer numReps, Integer duration) {
      super.id(id);
      super.exerciseName(exerciseName)
        .tools(tools)
        .numSets(numSets)
        .numReps(numReps)
        .duration(duration);
    }
    
    @Override
     public CopyOfBuilder exerciseName(String exerciseName) {
      return (CopyOfBuilder) super.exerciseName(exerciseName);
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
  }
  
}
