################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
CPP_SRCS += \
../wci/intermediate/symtabimpl/SymTabEntryImpl.cpp \
../wci/intermediate/symtabimpl/SymTabImpl.cpp \
../wci/intermediate/symtabimpl/SymTabStackImpl.cpp 

O_SRCS += \
../wci/intermediate/symtabimpl/SymTabEntryImpl.o \
../wci/intermediate/symtabimpl/SymTabImpl.o \
../wci/intermediate/symtabimpl/SymTabStackImpl.o 

OBJS += \
./wci/intermediate/symtabimpl/SymTabEntryImpl.o \
./wci/intermediate/symtabimpl/SymTabImpl.o \
./wci/intermediate/symtabimpl/SymTabStackImpl.o 

CPP_DEPS += \
./wci/intermediate/symtabimpl/SymTabEntryImpl.d \
./wci/intermediate/symtabimpl/SymTabImpl.d \
./wci/intermediate/symtabimpl/SymTabStackImpl.d 


# Each subdirectory must supply rules for building sources it contributes
wci/intermediate/symtabimpl/%.o: ../wci/intermediate/symtabimpl/%.cpp
	@echo 'Building file: $<'
	@echo 'Invoking: Cross G++ Compiler'
	g++ -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


