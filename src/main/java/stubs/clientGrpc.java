package stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: server.proto")
public final class clientGrpc {

  private clientGrpc() {}

  public static final String SERVICE_NAME = "proto.client";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<stubs.Order,
      stubs.APIResponse> getRegisterOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registerOrder",
      requestType = stubs.Order.class,
      responseType = stubs.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stubs.Order,
      stubs.APIResponse> getRegisterOrderMethod() {
    io.grpc.MethodDescriptor<stubs.Order, stubs.APIResponse> getRegisterOrderMethod;
    if ((getRegisterOrderMethod = clientGrpc.getRegisterOrderMethod) == null) {
      synchronized (clientGrpc.class) {
        if ((getRegisterOrderMethod = clientGrpc.getRegisterOrderMethod) == null) {
          clientGrpc.getRegisterOrderMethod = getRegisterOrderMethod = 
              io.grpc.MethodDescriptor.<stubs.Order, stubs.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.client", "registerOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stubs.Order.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stubs.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new clientMethodDescriptorSupplier("registerOrder"))
                  .build();
          }
        }
     }
     return getRegisterOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<stubs.OrderID,
      stubs.APIResponse> getCancelOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "cancelOrder",
      requestType = stubs.OrderID.class,
      responseType = stubs.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<stubs.OrderID,
      stubs.APIResponse> getCancelOrderMethod() {
    io.grpc.MethodDescriptor<stubs.OrderID, stubs.APIResponse> getCancelOrderMethod;
    if ((getCancelOrderMethod = clientGrpc.getCancelOrderMethod) == null) {
      synchronized (clientGrpc.class) {
        if ((getCancelOrderMethod = clientGrpc.getCancelOrderMethod) == null) {
          clientGrpc.getCancelOrderMethod = getCancelOrderMethod = 
              io.grpc.MethodDescriptor.<stubs.OrderID, stubs.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.client", "cancelOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stubs.OrderID.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  stubs.APIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new clientMethodDescriptorSupplier("cancelOrder"))
                  .build();
          }
        }
     }
     return getCancelOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static clientStub newStub(io.grpc.Channel channel) {
    return new clientStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static clientBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new clientBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static clientFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new clientFutureStub(channel);
  }

  /**
   */
  public static abstract class clientImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerOrder(stubs.Order request,
        io.grpc.stub.StreamObserver<stubs.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterOrderMethod(), responseObserver);
    }

    /**
     */
    public void cancelOrder(stubs.OrderID request,
        io.grpc.stub.StreamObserver<stubs.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                stubs.Order,
                stubs.APIResponse>(
                  this, METHODID_REGISTER_ORDER)))
          .addMethod(
            getCancelOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                stubs.OrderID,
                stubs.APIResponse>(
                  this, METHODID_CANCEL_ORDER)))
          .build();
    }
  }

  /**
   */
  public static final class clientStub extends io.grpc.stub.AbstractStub<clientStub> {
    private clientStub(io.grpc.Channel channel) {
      super(channel);
    }

    private clientStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected clientStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new clientStub(channel, callOptions);
    }

    /**
     */
    public void registerOrder(stubs.Order request,
        io.grpc.stub.StreamObserver<stubs.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelOrder(stubs.OrderID request,
        io.grpc.stub.StreamObserver<stubs.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelOrderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class clientBlockingStub extends io.grpc.stub.AbstractStub<clientBlockingStub> {
    private clientBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private clientBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected clientBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new clientBlockingStub(channel, callOptions);
    }

    /**
     */
    public stubs.APIResponse registerOrder(stubs.Order request) {
      return blockingUnaryCall(
          getChannel(), getRegisterOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public stubs.APIResponse cancelOrder(stubs.OrderID request) {
      return blockingUnaryCall(
          getChannel(), getCancelOrderMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class clientFutureStub extends io.grpc.stub.AbstractStub<clientFutureStub> {
    private clientFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private clientFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected clientFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new clientFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stubs.APIResponse> registerOrder(
        stubs.Order request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<stubs.APIResponse> cancelOrder(
        stubs.OrderID request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelOrderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_ORDER = 0;
  private static final int METHODID_CANCEL_ORDER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final clientImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(clientImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_ORDER:
          serviceImpl.registerOrder((stubs.Order) request,
              (io.grpc.stub.StreamObserver<stubs.APIResponse>) responseObserver);
          break;
        case METHODID_CANCEL_ORDER:
          serviceImpl.cancelOrder((stubs.OrderID) request,
              (io.grpc.stub.StreamObserver<stubs.APIResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class clientBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    clientBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return stubs.Server.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("client");
    }
  }

  private static final class clientFileDescriptorSupplier
      extends clientBaseDescriptorSupplier {
    clientFileDescriptorSupplier() {}
  }

  private static final class clientMethodDescriptorSupplier
      extends clientBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    clientMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (clientGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new clientFileDescriptorSupplier())
              .addMethod(getRegisterOrderMethod())
              .addMethod(getCancelOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
