Notification -> QueueingSystem
Broadcast->user message sent to multiple users
Content -> Text/Image/Video
Contact -> username/phone

1. Sync Contacts can be async too, it is not needed to be part of signup process. It can be background job on user
   device, making call to user service.
   Not adding code change for same to save time
2. Skipped Exception Handling to save time,
   add [UploadResponseException.java](main%2Fjava%2Forg%2Ftest%2Fcontent%2Fexceptions%2FUploadResponseException.java)
   to illustrate how it ll be done at other places
3. Logging skipped as a concios choice to save time
4. Metric tracking skipped as a concios choice to save time
5. Comments skipped as a concios choice to save time
6. Added TODOs where I need to come back for enhancement
7. Skipped implementing VideoUploadService to save time