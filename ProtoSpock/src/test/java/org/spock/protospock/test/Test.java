// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: src/test/protobuf/Test.proto

package org.spock.protospock.test;

public final class Test {
  private Test() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class Person extends
      com.google.protobuf.GeneratedMessage {
    // Use Person.newBuilder() to construct.
    private Person() {
      initFields();
    }
    private Person(boolean noInit) {}
    
    private static final Person defaultInstance;
    public static Person getDefaultInstance() {
      return defaultInstance;
    }
    
    public Person getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.spock.protospock.test.Test.internal_static_Person_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.spock.protospock.test.Test.internal_static_Person_fieldAccessorTable;
    }
    
    // required string id = 1;
    public static final int ID_FIELD_NUMBER = 1;
    private boolean hasId;
    private java.lang.String id_ = "";
    public boolean hasId() { return hasId; }
    public java.lang.String getId() { return id_; }
    
    // required string firstName = 2;
    public static final int FIRSTNAME_FIELD_NUMBER = 2;
    private boolean hasFirstName;
    private java.lang.String firstName_ = "";
    public boolean hasFirstName() { return hasFirstName; }
    public java.lang.String getFirstName() { return firstName_; }
    
    // required string surname = 3;
    public static final int SURNAME_FIELD_NUMBER = 3;
    private boolean hasSurname;
    private java.lang.String surname_ = "";
    public boolean hasSurname() { return hasSurname; }
    public java.lang.String getSurname() { return surname_; }
    
    // optional string email = 4;
    public static final int EMAIL_FIELD_NUMBER = 4;
    private boolean hasEmail;
    private java.lang.String email_ = "";
    public boolean hasEmail() { return hasEmail; }
    public java.lang.String getEmail() { return email_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      if (!hasId) return false;
      if (!hasFirstName) return false;
      if (!hasSurname) return false;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasId()) {
        output.writeString(1, getId());
      }
      if (hasFirstName()) {
        output.writeString(2, getFirstName());
      }
      if (hasSurname()) {
        output.writeString(3, getSurname());
      }
      if (hasEmail()) {
        output.writeString(4, getEmail());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasId()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(1, getId());
      }
      if (hasFirstName()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(2, getFirstName());
      }
      if (hasSurname()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(3, getSurname());
      }
      if (hasEmail()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(4, getEmail());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static org.spock.protospock.test.Test.Person parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static org.spock.protospock.test.Test.Person parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static org.spock.protospock.test.Test.Person parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static org.spock.protospock.test.Test.Person parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static org.spock.protospock.test.Test.Person parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static org.spock.protospock.test.Test.Person parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static org.spock.protospock.test.Test.Person parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static org.spock.protospock.test.Test.Person parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static org.spock.protospock.test.Test.Person parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static org.spock.protospock.test.Test.Person parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(org.spock.protospock.test.Test.Person prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private org.spock.protospock.test.Test.Person result;
      
      // Construct using org.spock.protospock.test.Test.Person.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new org.spock.protospock.test.Test.Person();
        return builder;
      }
      
      protected org.spock.protospock.test.Test.Person internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new org.spock.protospock.test.Test.Person();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.spock.protospock.test.Test.Person.getDescriptor();
      }
      
      public org.spock.protospock.test.Test.Person getDefaultInstanceForType() {
        return org.spock.protospock.test.Test.Person.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public org.spock.protospock.test.Test.Person build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private org.spock.protospock.test.Test.Person buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public org.spock.protospock.test.Test.Person buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        org.spock.protospock.test.Test.Person returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof org.spock.protospock.test.Test.Person) {
          return mergeFrom((org.spock.protospock.test.Test.Person)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(org.spock.protospock.test.Test.Person other) {
        if (other == org.spock.protospock.test.Test.Person.getDefaultInstance()) return this;
        if (other.hasId()) {
          setId(other.getId());
        }
        if (other.hasFirstName()) {
          setFirstName(other.getFirstName());
        }
        if (other.hasSurname()) {
          setSurname(other.getSurname());
        }
        if (other.hasEmail()) {
          setEmail(other.getEmail());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 10: {
              setId(input.readString());
              break;
            }
            case 18: {
              setFirstName(input.readString());
              break;
            }
            case 26: {
              setSurname(input.readString());
              break;
            }
            case 34: {
              setEmail(input.readString());
              break;
            }
          }
        }
      }
      
      
      // required string id = 1;
      public boolean hasId() {
        return result.hasId();
      }
      public java.lang.String getId() {
        return result.getId();
      }
      public Builder setId(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasId = true;
        result.id_ = value;
        return this;
      }
      public Builder clearId() {
        result.hasId = false;
        result.id_ = getDefaultInstance().getId();
        return this;
      }
      
      // required string firstName = 2;
      public boolean hasFirstName() {
        return result.hasFirstName();
      }
      public java.lang.String getFirstName() {
        return result.getFirstName();
      }
      public Builder setFirstName(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasFirstName = true;
        result.firstName_ = value;
        return this;
      }
      public Builder clearFirstName() {
        result.hasFirstName = false;
        result.firstName_ = getDefaultInstance().getFirstName();
        return this;
      }
      
      // required string surname = 3;
      public boolean hasSurname() {
        return result.hasSurname();
      }
      public java.lang.String getSurname() {
        return result.getSurname();
      }
      public Builder setSurname(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasSurname = true;
        result.surname_ = value;
        return this;
      }
      public Builder clearSurname() {
        result.hasSurname = false;
        result.surname_ = getDefaultInstance().getSurname();
        return this;
      }
      
      // optional string email = 4;
      public boolean hasEmail() {
        return result.hasEmail();
      }
      public java.lang.String getEmail() {
        return result.getEmail();
      }
      public Builder setEmail(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasEmail = true;
        result.email_ = value;
        return this;
      }
      public Builder clearEmail() {
        result.hasEmail = false;
        result.email_ = getDefaultInstance().getEmail();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:Person)
    }
    
    static {
      defaultInstance = new Person(true);
      org.spock.protospock.test.Test.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:Person)
  }
  
  public static final class SystemRoleCompanyScope extends
      com.google.protobuf.GeneratedMessage {
    // Use SystemRoleCompanyScope.newBuilder() to construct.
    private SystemRoleCompanyScope() {
      initFields();
    }
    private SystemRoleCompanyScope(boolean noInit) {}
    
    private static final SystemRoleCompanyScope defaultInstance;
    public static SystemRoleCompanyScope getDefaultInstance() {
      return defaultInstance;
    }
    
    public SystemRoleCompanyScope getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.spock.protospock.test.Test.internal_static_SystemRoleCompanyScope_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.spock.protospock.test.Test.internal_static_SystemRoleCompanyScope_fieldAccessorTable;
    }
    
    // optional string system = 1;
    public static final int SYSTEM_FIELD_NUMBER = 1;
    private boolean hasSystem;
    private java.lang.String system_ = "";
    public boolean hasSystem() { return hasSystem; }
    public java.lang.String getSystem() { return system_; }
    
    // optional string role = 2;
    public static final int ROLE_FIELD_NUMBER = 2;
    private boolean hasRole;
    private java.lang.String role_ = "";
    public boolean hasRole() { return hasRole; }
    public java.lang.String getRole() { return role_; }
    
    // optional string company = 3;
    public static final int COMPANY_FIELD_NUMBER = 3;
    private boolean hasCompany;
    private java.lang.String company_ = "";
    public boolean hasCompany() { return hasCompany; }
    public java.lang.String getCompany() { return company_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasSystem()) {
        output.writeString(1, getSystem());
      }
      if (hasRole()) {
        output.writeString(2, getRole());
      }
      if (hasCompany()) {
        output.writeString(3, getCompany());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasSystem()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(1, getSystem());
      }
      if (hasRole()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(2, getRole());
      }
      if (hasCompany()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(3, getCompany());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static org.spock.protospock.test.Test.SystemRoleCompanyScope parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static org.spock.protospock.test.Test.SystemRoleCompanyScope parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static org.spock.protospock.test.Test.SystemRoleCompanyScope parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static org.spock.protospock.test.Test.SystemRoleCompanyScope parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static org.spock.protospock.test.Test.SystemRoleCompanyScope parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static org.spock.protospock.test.Test.SystemRoleCompanyScope parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static org.spock.protospock.test.Test.SystemRoleCompanyScope parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static org.spock.protospock.test.Test.SystemRoleCompanyScope parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static org.spock.protospock.test.Test.SystemRoleCompanyScope parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static org.spock.protospock.test.Test.SystemRoleCompanyScope parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(org.spock.protospock.test.Test.SystemRoleCompanyScope prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private org.spock.protospock.test.Test.SystemRoleCompanyScope result;
      
      // Construct using org.spock.protospock.test.Test.SystemRoleCompanyScope.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new org.spock.protospock.test.Test.SystemRoleCompanyScope();
        return builder;
      }
      
      protected org.spock.protospock.test.Test.SystemRoleCompanyScope internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new org.spock.protospock.test.Test.SystemRoleCompanyScope();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return org.spock.protospock.test.Test.SystemRoleCompanyScope.getDescriptor();
      }
      
      public org.spock.protospock.test.Test.SystemRoleCompanyScope getDefaultInstanceForType() {
        return org.spock.protospock.test.Test.SystemRoleCompanyScope.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public org.spock.protospock.test.Test.SystemRoleCompanyScope build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private org.spock.protospock.test.Test.SystemRoleCompanyScope buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public org.spock.protospock.test.Test.SystemRoleCompanyScope buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        org.spock.protospock.test.Test.SystemRoleCompanyScope returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof org.spock.protospock.test.Test.SystemRoleCompanyScope) {
          return mergeFrom((org.spock.protospock.test.Test.SystemRoleCompanyScope)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(org.spock.protospock.test.Test.SystemRoleCompanyScope other) {
        if (other == org.spock.protospock.test.Test.SystemRoleCompanyScope.getDefaultInstance()) return this;
        if (other.hasSystem()) {
          setSystem(other.getSystem());
        }
        if (other.hasRole()) {
          setRole(other.getRole());
        }
        if (other.hasCompany()) {
          setCompany(other.getCompany());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 10: {
              setSystem(input.readString());
              break;
            }
            case 18: {
              setRole(input.readString());
              break;
            }
            case 26: {
              setCompany(input.readString());
              break;
            }
          }
        }
      }
      
      
      // optional string system = 1;
      public boolean hasSystem() {
        return result.hasSystem();
      }
      public java.lang.String getSystem() {
        return result.getSystem();
      }
      public Builder setSystem(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasSystem = true;
        result.system_ = value;
        return this;
      }
      public Builder clearSystem() {
        result.hasSystem = false;
        result.system_ = getDefaultInstance().getSystem();
        return this;
      }
      
      // optional string role = 2;
      public boolean hasRole() {
        return result.hasRole();
      }
      public java.lang.String getRole() {
        return result.getRole();
      }
      public Builder setRole(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasRole = true;
        result.role_ = value;
        return this;
      }
      public Builder clearRole() {
        result.hasRole = false;
        result.role_ = getDefaultInstance().getRole();
        return this;
      }
      
      // optional string company = 3;
      public boolean hasCompany() {
        return result.hasCompany();
      }
      public java.lang.String getCompany() {
        return result.getCompany();
      }
      public Builder setCompany(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasCompany = true;
        result.company_ = value;
        return this;
      }
      public Builder clearCompany() {
        result.hasCompany = false;
        result.company_ = getDefaultInstance().getCompany();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:SystemRoleCompanyScope)
    }
    
    static {
      defaultInstance = new SystemRoleCompanyScope(true);
      org.spock.protospock.test.Test.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:SystemRoleCompanyScope)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_Person_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Person_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_SystemRoleCompanyScope_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_SystemRoleCompanyScope_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034src/test/protobuf/Test.proto\"G\n\006Person" +
      "\022\n\n\002id\030\001 \002(\t\022\021\n\tfirstName\030\002 \002(\t\022\017\n\007surna" +
      "me\030\003 \002(\t\022\r\n\005email\030\004 \001(\t\"G\n\026SystemRoleCom" +
      "panyScope\022\016\n\006system\030\001 \001(\t\022\014\n\004role\030\002 \001(\t\022" +
      "\017\n\007company\030\003 \001(\tB\033\n\031org.spock.protospock" +
      ".test"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_Person_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_Person_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_Person_descriptor,
              new java.lang.String[] { "Id", "FirstName", "Surname", "Email", },
              org.spock.protospock.test.Test.Person.class,
              org.spock.protospock.test.Test.Person.Builder.class);
          internal_static_SystemRoleCompanyScope_descriptor =
            getDescriptor().getMessageTypes().get(1);
          internal_static_SystemRoleCompanyScope_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_SystemRoleCompanyScope_descriptor,
              new java.lang.String[] { "System", "Role", "Company", },
              org.spock.protospock.test.Test.SystemRoleCompanyScope.class,
              org.spock.protospock.test.Test.SystemRoleCompanyScope.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}
