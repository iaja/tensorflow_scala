/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class org_platanios_tensorflow_jni_RecordReader__ */

#ifndef _Included_org_platanios_tensorflow_jni_RecordReader__
#define _Included_org_platanios_tensorflow_jni_RecordReader__
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     org_platanios_tensorflow_jni_RecordReader__
 * Method:    newRandomAccessFile
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_platanios_tensorflow_jni_RecordReader_00024_newRandomAccessFile
  (JNIEnv *, jobject, jstring);

/*
 * Class:     org_platanios_tensorflow_jni_RecordReader__
 * Method:    deleteRandomAccessFile
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_platanios_tensorflow_jni_RecordReader_00024_deleteRandomAccessFile
  (JNIEnv *, jobject, jlong);

/*
 * Class:     org_platanios_tensorflow_jni_RecordReader__
 * Method:    newRecordReader
 * Signature: (JLjava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_platanios_tensorflow_jni_RecordReader_00024_newRecordReader
  (JNIEnv *, jobject, jlong, jstring);

/*
 * Class:     org_platanios_tensorflow_jni_RecordReader__
 * Method:    recordReaderRead
 * Signature: (JJ)[B
 */
JNIEXPORT jbyteArray JNICALL Java_org_platanios_tensorflow_jni_RecordReader_00024_recordReaderRead
  (JNIEnv *, jobject, jlong, jlong);

/*
 * Class:     org_platanios_tensorflow_jni_RecordReader__
 * Method:    deleteRecordReader
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_platanios_tensorflow_jni_RecordReader_00024_deleteRecordReader
  (JNIEnv *, jobject, jlong);

/*
 * Class:     org_platanios_tensorflow_jni_RecordReader__
 * Method:    newSequentialRecordReader
 * Signature: (JLjava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_org_platanios_tensorflow_jni_RecordReader_00024_newSequentialRecordReader
  (JNIEnv *, jobject, jlong, jstring);

/*
 * Class:     org_platanios_tensorflow_jni_RecordReader__
 * Method:    sequentialRecordReaderReadNext
 * Signature: (J)[B
 */
JNIEXPORT jbyteArray JNICALL Java_org_platanios_tensorflow_jni_RecordReader_00024_sequentialRecordReaderReadNext
  (JNIEnv *, jobject, jlong);

/*
 * Class:     org_platanios_tensorflow_jni_RecordReader__
 * Method:    deleteSequentialRecordReader
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_platanios_tensorflow_jni_RecordReader_00024_deleteSequentialRecordReader
  (JNIEnv *, jobject, jlong);

/*
 * Class:     org_platanios_tensorflow_jni_RecordReader__
 * Method:    newRecordReaderWrapper
 * Signature: (Ljava/lang/String;Ljava/lang/String;J)J
 */
JNIEXPORT jlong JNICALL Java_org_platanios_tensorflow_jni_RecordReader_00024_newRecordReaderWrapper
  (JNIEnv *, jobject, jstring, jstring, jlong);

/*
 * Class:     org_platanios_tensorflow_jni_RecordReader__
 * Method:    recordReaderWrapperReadNext
 * Signature: (J)[B
 */
JNIEXPORT jbyteArray JNICALL Java_org_platanios_tensorflow_jni_RecordReader_00024_recordReaderWrapperReadNext
  (JNIEnv *, jobject, jlong);

/*
 * Class:     org_platanios_tensorflow_jni_RecordReader__
 * Method:    recordReaderWrapperOffset
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_org_platanios_tensorflow_jni_RecordReader_00024_recordReaderWrapperOffset
  (JNIEnv *, jobject, jlong);

/*
 * Class:     org_platanios_tensorflow_jni_RecordReader__
 * Method:    deleteRecordReaderWrapper
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_org_platanios_tensorflow_jni_RecordReader_00024_deleteRecordReaderWrapper
  (JNIEnv *, jobject, jlong);

#ifdef __cplusplus
}
#endif
#endif
