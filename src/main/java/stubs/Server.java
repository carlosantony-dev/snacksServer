// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: server.proto

package stubs;

public final class Server {
  private Server() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_Order_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_Order_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_OrderID_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_OrderID_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_APIResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_APIResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014server.proto\022\005proto\"B\n\005Order\022\014\n\004name\030\001" +
      " \001(\t\022\025\n\rcustomerTable\030\002 \001(\003\022\024\n\014observati" +
      "ons\030\003 \001(\t\"\036\n\007OrderID\022\023\n\013orderNumber\030\001 \001(" +
      "\005\";\n\013APIResponse\022\027\n\017responseMessage\030\001 \001(" +
      "\t\022\023\n\013messageCode\030\002 \001(\0052n\n\006client\0221\n\rregi" +
      "sterOrder\022\014.proto.Order\032\022.proto.APIRespo" +
      "nse\0221\n\013cancelOrder\022\016.proto.OrderID\032\022.pro" +
      "to.APIResponseB\t\n\005stubsP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_proto_Order_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_Order_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_Order_descriptor,
        new java.lang.String[] { "Name", "CustomerTable", "Observations", });
    internal_static_proto_OrderID_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_proto_OrderID_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_OrderID_descriptor,
        new java.lang.String[] { "OrderNumber", });
    internal_static_proto_APIResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_proto_APIResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_APIResponse_descriptor,
        new java.lang.String[] { "ResponseMessage", "MessageCode", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
