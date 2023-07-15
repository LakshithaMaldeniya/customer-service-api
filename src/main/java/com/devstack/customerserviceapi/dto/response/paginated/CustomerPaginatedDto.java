package com.devstack.customerserviceapi.dto.response.paginated;

import com.devstack.customerserviceapi.dto.response.ResponseCustomerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPaginatedDto {

    private long dataCount;
    private List<ResponseCustomerDto> list;

}
