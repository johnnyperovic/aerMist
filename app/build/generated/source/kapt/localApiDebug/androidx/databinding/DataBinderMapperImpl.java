package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new llc.aerMist.app.DataBinderMapperImpl());
  }
}
