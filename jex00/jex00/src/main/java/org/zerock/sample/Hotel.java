package org.zerock.sample;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ToString
@Getter
@RequiredArgsConstructor
public class Hotel {
    private final Chef chef;
}
