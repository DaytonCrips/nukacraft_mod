@echo off
setlocal enabledelayedexpansion

set "search_word=t45"
set "replace_word=t51"
set "folder_path=D:\Projects\Minecraft\nukacraft_mod\src\main\resources\assets\nukacraft\config\model\equipment"

md "%temp_folder%" 2>nul

for %%F in ("%folder_path%\%search_word%*") do (
    set "file_name=%%~nxF"
    set "new_file_name=!file_name:%search_word%=%replace_word%!"
    
    set "temp_file=%temp_folder%\!new_file_name!"
    
    copy "%%F" "!temp_file!"
    
    (for /f "usebackq delims=" %%L in ("!temp_file!") do (
        set "line=%%L"
        setlocal enabledelayedexpansion
        echo(!line:%search_word%=%replace_word%!
        endlocal
    )) > "!temp_file!.tmp"
    
    move /y "!temp_file!.tmp" "%%F" >nul
)

rd /s /q "%temp_folder%" 2>nul
