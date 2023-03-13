set(EXECUTABLE_OUTPUT_PATH "${PROJECT_SOURCE_DIR}/bin")
set(custom_include_dirs  "${PROJECT_SOURCE_DIR}/include"  "D:/cppproject/c项目/dependencies/glfw-3.3.8.bin.WIN64/include"
"D:/program/Vulkan/Include" "D:/cppproject/stb-master")

include_directories(${custom_include_dirs})

file(GLOB sourcecppfiles
    "${PROJECT_SOURCE_DIR}/src/*.cpp"
    "${PROJECT_SOURCE_DIR}/src/class/*.cpp"
    "${PROJECT_SOURCE_DIR}/src/imguisourcefiles/*.cpp"
)

set(linkdir "D:/cppproject/c项目/dependencies/glfw-3.3.8.bin.WIN64/lib-mingw-w64" "D:/program/Vulkan/Lib" )

link_directories(${linkdir})

add_executable(${PROJECT_NAME} ${sourcecppfiles})

target_link_libraries(${PROJECT_NAME} glfw3 vulkan-1)
