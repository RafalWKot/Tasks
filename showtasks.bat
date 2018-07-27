call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo runcrud.bat has errors - breaking work
goto fail

:browser
start firefox http://localhost:8888/tasks_frontend/
if "%ERRORLEVEL%" == "0" goto :end
echo.
echo start web browser has errors - breaking work


:fail
echo.
echo There were errors

:end
echo.
echo showtasks.bat is finished.