################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../wci/intermediate/ICodeFactory.cpp \
../wci/intermediate/SymTabFactory.cpp 

O_SRCS += \
../wci/intermediate/ICodeFactory.o \
../wci/intermediate/SymTabFactory.o 

OBJS += \
./wci/intermediate/ICodeFactory.o \
./wci/intermediate/SymTabFactory.o 

CPP_DEPS += \
./wci/intermediate/ICodeFactory.d \
./wci/intermediate/SymTabFactory.d 


# Each subdirectory must supply rules for building sources it contributes
wci/intermediate/%.o: ../wci/intermediate/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cross G++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


